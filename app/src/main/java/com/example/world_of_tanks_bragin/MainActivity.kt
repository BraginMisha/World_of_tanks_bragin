package com.example.world_of_tanks_bragin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import com.example.world_of_tanks_bragin.Diraction.UP
import com.example.world_of_tanks_bragin.Diraction.DOWN
import com.example.world_of_tanks_bragin.Diraction.LEFT
import com.example.world_of_tanks_bragin.Diraction.RIGHT
import com.example.world_of_tanks_bragin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

override fun onKeyDown(KeyCode: Int, event: KeyEvent?): Bootlean {
    when (KeyCode) {
        KEYCODE_DPAD_UP -> move(UP)
        KEYCODE_DPAD_DOWN ->move(DOWN)
        KEYCODE_DPAD_LEFT ->move(LEFT)
        KEYCODE_DPAD_RIGHT ->move(RIGHT)
    }
    return super.onKeyDown(KeyCode, event)
}

private fun move(diraction: Diraction) {
    when (diraction) {
        UP -> {
            binding.myTank.rototion = 0f
            (binding.MyTank.layoutParams as FrameLaoyt.LayoutParams).topMargin += -50
        }

        DOWN -> {
            binding.MyTank.rototion = 180f
            (binding.MyTank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
        }

        LEFT -> {
            binding.MyTank.rototion = 270f
            (binding.MyTank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
        }

        RIGHT -> {
            binding.MyTank.rototion = 90f
            (binding.MyTank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
        }
    }


    binding.container.removeView(binding.myTank)
    binding.container.addView(binding.myTank)
}
