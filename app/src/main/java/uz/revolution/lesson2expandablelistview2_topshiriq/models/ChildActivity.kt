package uz.revolution.lesson2expandablelistview2_topshiriq.models

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_child.*
import uz.revolution.lesson2expandablelistview2_topshiriq.R

class ChildActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)

        val name = intent?.getStringExtra("name")

        child_name.text = name

    }
}