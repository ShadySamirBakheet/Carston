package com.ozady.carston.views.videos

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.*
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.android.material.slider.Slider
import com.ozady.carston.databinding.ActivityVideoViewFullBinding
import com.ozady.carston.R
import com.ozady.carston.utils.Values.Companion.TAG


class VideoViewFullActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideoViewFullBinding

    var mediaUrl = ""
    var postion:Long = 0

    var isFirst = true

    enum class PlayState {
        ON, OFF
    }

    private var isStartBar: Boolean = false
    lateinit var videoPlayer: PlayerView
    lateinit var videoPlayerSrc: SimpleExoPlayer
    lateinit var  dataSourceFactory: DataSource.Factory
    lateinit var progressVideo: Slider
    lateinit var progressBar: ProgressBar
    lateinit var timeLeftView: TextView
    lateinit var exit: ImageView
    lateinit var playControl: ImageView
    lateinit var zoomIn: ImageView
    lateinit var videoCon: RelativeLayout
    lateinit var mediaControls: RelativeLayout
    lateinit var progressVideo2: ProgressBar

    var playState: PlayState = PlayState.ON

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoViewFullBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mediaUrl = intent.getStringExtra("mediaUrl").toString()
        postion = intent.getLongExtra("postion",0)

        mediaUrl = "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Rest+api+teaser+video.mp4"

        initFun()
    }

    private fun initFun() {

        videoPlayer = binding.videoPlayer
        progressVideo = binding.progressVideo
        timeLeftView = binding.timeLeftView
        exit = binding.zoomIn
        playControl = binding.playControl
        progressBar = binding.progressBar
        zoomIn = binding.zoomIn
        videoCon = binding.videoCon
        mediaControls = binding.mediaControls
        progressVideo2 = binding.progressVideo2
        progressVideo.isEnabled = false

        videoCon.setOnClickListener {
            if (mediaControls.visibility == GONE){
                mediaControls.visibility = VISIBLE
                toggleMediaControls()
            }else{
                mediaControls.visibility = GONE
            }
        }

        exit.setOnClickListener {
            finish()
        }

        playControl.setOnClickListener {
            togglePlay()
            toggleMediaControls()
        }

        progressVideo.addOnChangeListener { slider, value, fromUser ->

            if (fromUser){
                toggleMediaControls()
                val seekValue = videoPlayerSrc.contentDuration * (value/100)
                slider.setLabelFormatter {
                    return@setLabelFormatter getTextTime((seekValue).toLong())
                }
                videoPlayerSrc.seekTo(seekValue.toLong())
            }

        }

        pepaerVideo()

    }

    private fun toggleMediaControls() {
        mediaControls.bringToFront()
        if (playState == PlayState.OFF) {
            playControl.setImageResource(R.drawable.ic_play)
        } else if (playState == PlayState.ON) {
            playControl.setImageResource(R.drawable.ic_pause)
        }
        mediaControls.animate().cancel()
        mediaControls.alpha = 1f
        mediaControls.animate()
            .alpha(0f)
            .setDuration(3000).startDelay = 1000

        Handler().postDelayed({
            mediaControls.visibility = GONE
        },3000)
    }

    private fun togglePlay() {
        if (playState == PlayState.OFF) {
            Log.d(TAG, "togglePlaybackState: enabling Play.")
            setVolumePlay(PlayState.ON)
        } else if (playState == PlayState.ON) {
            Log.d(TAG, "togglePlaybackState: disabling Play.")
            setVolumePlay(PlayState.OFF)
        }
    }

    private fun setVolumePlay(state: PlayState) {
        playState = state
        if (state == PlayState.OFF) {
            videoPlayerSrc.playWhenReady = false
            videoPlayerSrc.playbackState
            animatePlayControl()
        } else if (state == PlayState.ON) {
            videoPlayerSrc.playWhenReady = true
            videoPlayerSrc.playbackState
            animatePlayControl()
        }
    }

    private fun animatePlayControl() {
        playControl.bringToFront()
        if (playState == PlayState.OFF) {
            playControl.setImageResource(R.drawable.ic_pause)
        } else if (playState == PlayState.ON) {
            playControl.setImageResource(R.drawable.ic_play)
        }
        /*     playControl.animate().cancel()
             playControl.alpha = 1f
             playControl.animate()
                 .alpha(0f)
                 .setDuration(600).startDelay = 1000*/
    }

    private fun runVideo() {
        progressVideo.isEnabled = true
        val videoSource: MediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(mediaUrl))
        videoPlayerSrc.prepare(videoSource)
        videoPlayer.player = videoPlayerSrc
        videoPlayer.useController = false
        videoPlayer.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
        videoPlayerSrc.playWhenReady = true

        videoPlayerSrc.addListener(object : Player.EventListener{
            override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
//                TODO("Not yet implemented")
            }

            override fun onTracksChanged(
                trackGroups: TrackGroupArray?,
                trackSelections: TrackSelectionArray?
            ) {
                // TODO("Not yet implemented")
            }

            override fun onLoadingChanged(isLoading: Boolean) {
                //TODO("Not yet implemented")
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {

                if (playWhenReady){
                    progressVideo.visibility = VISIBLE
                    isStartBar = true
                    startBar()
                }else{
                    stopBar()
                }


                when (playbackState) {
                    Player.STATE_BUFFERING -> {
                        Log.e(TAG, "onPlayerStateChanged: Buffering video.")
                        progressBar.visibility = VISIBLE
                    }
                    Player.STATE_ENDED -> {
                        Log.d(TAG, "onPlayerStateChanged: Video ended.")
                        stopBar()
                        ///videoPlayerSrc.seekTo(0)
                    }
                    Player.STATE_IDLE -> {
                        Log.d(TAG, "onPlayerStateChanged: Video STATE_IDLE.")
                    }
                    Player.STATE_READY -> {
                        if (isFirst){
                            videoPlayerSrc.seekTo(postion)
                            isFirst = false
                        }
                        Log.e(TAG, "onPlayerStateChanged: Ready to play.")
                        progressBar.visibility = GONE
                    }
                    else -> {
                        Log.d(TAG, "onPlayerStateChanged: Video else.")
                    }
                }
            }

            override fun onRepeatModeChanged(repeatMode: Int) {
                //TODO("Not yet implemented")
            }

            override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
                //TODO("Not yet implemented")
            }

            override fun onPlayerError(error: ExoPlaybackException?) {
                //TODO("Not yet implemented")
            }

            override fun onPositionDiscontinuity(reason: Int) {
                //TODO("Not yet implemented")
            }

            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
                //TODO("Not yet implemented")
            }

            override fun onSeekProcessed() {
                //TODO("Not yet implemented")
            }
        })

    }

    private fun stopBar() {
        //progressVideo.visibility = RecyclerView.GONE
        isStartBar = false
    }

    private fun startBar() {
        if (isStartBar && progressVideo!=null && timeLeftView!=null){
            val timeNow = videoPlayerSrc.currentPosition
            val timeAll = videoPlayerSrc.duration
            val duration = (timeNow.toDouble() / timeAll.toDouble())
            val progress = duration * 100f
            if (progress >= 0 && progress <= 100){
                progressVideo.value = progress.toFloat()
            }
            timeLeftView.text = getTextTime(timeAll-timeNow)
            //   Log.d(TAG, "startBar: called. $timeNow  $timeAll $duration ${progress.toInt()}")
            wiatFun()
        }else{
            isStartBar = false
        }
    }

    private fun getTextTime(timeLeft: Long): String {
        if (timeLeft in 1..6299999999){
            var string = ""
            val sec = timeLeft/1000
            val min = sec/60
            val secl = sec%60
            string = "$min:$secl"
            return string
        }else{
            return "00:00"
        }
    }

    private fun wiatFun() {
        val handler = Handler()
        handler.postDelayed({
            startBar()
        }, 500)
    }

    private fun pepaerVideo() {

        dataSourceFactory = DefaultDataSourceFactory(
            this, Util.getUserAgent(this, "Log Apps")
        )
        val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()
        val videoTrackSelectionFactory: TrackSelection.Factory =
            AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector: TrackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
        videoPlayerSrc = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        runVideo()
    }

    override fun onPause() {
        videoPlayerSrc.playWhenReady = false
        videoPlayerSrc.playbackState
        super.onPause()
    }

    override fun onBackPressed() {
        videoPlayerSrc.playWhenReady = false
        videoPlayerSrc.playbackState
        super.onBackPressed()
    }
}