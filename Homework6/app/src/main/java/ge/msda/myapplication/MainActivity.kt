package ge.msda.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val pagerAdapter = PagerAdapter(supportFragmentManager)
            val pager = findViewById<ViewPager>(R.id.viewpager)
            pager.adapter = pagerAdapter


        }
    }


