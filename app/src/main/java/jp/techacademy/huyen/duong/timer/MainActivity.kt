package jp.techacademy.huyen.duong.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import jp.techacademy.huyen.duong.timer.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: Timer? = null

    // タイマー用の時間のための変数
    private var seconds = 0.0
    private var handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        // タイマーの作成
//        timer = Timer()
//
//        // タイマーの始動
//        timer!!.schedule(object : TimerTask() {
//            override fun run() {
//                seconds += 0.1
//                handler.post {
//                    binding.timer.text = String.format("%.1f", seconds)
//                }
//            }
//        }, 200, 100) // 最初に始動させるまで200ミリ秒、ループの間隔を100ミリ秒 に設定
        binding.startButton.setOnClickListener() {
            if (timer == null) {
                timer = Timer()
                timer!!.schedule(object : TimerTask() {
                    override fun run() {
                        seconds += 0.1
                        handler.post {
                            binding.timer.text = String.format("%.1f", seconds)
                        }
                    }
                }, 200, 100)
            }
        }
        binding.pauseButton.setOnClickListener() {
            if (timer != null) {
                timer!!.cancel()
                timer = null
            }
        }
        binding.resetButton.setOnClickListener() {
            seconds = 0.0
            binding.timer.text = String.format("%.1f",seconds)
        }
    }
}