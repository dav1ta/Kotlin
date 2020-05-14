package ge.msda.myapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ge.msda.myapplication.R
import kotlinx.android.synthetic.main.fragment_notification.view.*



class NotificationFragment : Fragment(R.layout.fragment_notification) {



    fun newInstance():NotificationFragment {

        val frag = NotificationFragment()
        return frag
    }



}