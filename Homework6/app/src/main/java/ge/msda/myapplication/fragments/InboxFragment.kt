package ge.msda.myapplication.fragments
import androidx.fragment.app.Fragment
import ge.msda.myapplication.R


class InboxFragment : Fragment(R.layout.fragment_inbox) {


    fun newInstance():InboxFragment {

        val frag = InboxFragment()
        return frag
    }


}