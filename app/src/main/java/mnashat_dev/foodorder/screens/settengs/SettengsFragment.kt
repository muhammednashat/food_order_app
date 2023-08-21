package mnashat_dev.foodorder.screens.settengs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mnashat_dev.foodorder.R

class SettengsFragment : Fragment() {

    companion object {
        fun newInstance() = SettengsFragment()
    }

    private lateinit var viewModel: SettengsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settengs, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettengsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}