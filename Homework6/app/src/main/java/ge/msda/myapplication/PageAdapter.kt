package ge.msda.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ge.msda.myapplication.fragments.DashboardFragment
import ge.msda.myapplication.fragments.HomeFragment
import ge.msda.myapplication.fragments.InboxFragment
import ge.msda.myapplication.fragments.NotificationFragment

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm)
{
    val PAGE_MAX_CNT = 4

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment {
        val fragment = when(position)
        {
            1 -> DashboardFragment().newInstance()
            2 -> HomeFragment().newInstance()
            3 -> NotificationFragment().newInstance()
            else -> InboxFragment().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            1 -> "one"
            2 -> "tow"
            3 -> "three"
            else -> "main"
        }
        return title
    }


}