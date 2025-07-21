package com.example.singlelivedatatest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.singlelivedatatest.databinding.ActivitySecondBinding

/**
 *  테스트 순서
 * 앱 실행 후 MainActivity에서
 *
 * LiveData로 이동 버튼 클릭 → SecondActivity로 전환
 *
 * "Main으로 돌아가기" 클릭 → MainActivity 복귀
 *
 * 이 상태에서 화면 회전 (LiveData 옵저버가 재등록됨)
 * → ❗ LiveData 이벤트가 재전달되어 SecondActivity 다시 실행됨
 *
 * 앱 재실행 후
 *
 * SingleLiveData로 이동 버튼 클릭 → SecondActivity 전환
 *
 * "Main으로 돌아가기" 클릭 → MainActivity 복귀
 *
 * 화면 회전
 * → 아무 일도 없음 (이전 이벤트는 소비 완료됨)
 * */

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
