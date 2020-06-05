package ge.msda.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import ge.msda.myapplication.adapters.ViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        viewpager.adapter = viewPagerFragmentAdapter



        var imageIdList = arrayOf<Int>(
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_bluetooth_black_24dp,
            R.drawable.ic_cloud_upload_black_24dp
        )

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.setIcon(imageIdList[position])
        }.attach()

    }

}