package mnashat_dev.foodorder.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import mnashat_dev.foodorder.CategoryAdapter
import mnashat_dev.foodorder.CategoryListener
import mnashat_dev.foodorder.PopularAdapter
import mnashat_dev.foodorder.PopularListener
import mnashat_dev.foodorder.data.listOfCategory
import mnashat_dev.foodorder.data.listOfPopular
import mnashat_dev.foodorder.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var popularAdapter: PopularAdapter


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerview()
    }

    private fun setUpRecyclerview() {
        categoryAdapter = CategoryAdapter(CategoryListener { })
            .apply {
                submitList(listOfCategory)
            }
        popularAdapter = PopularAdapter(PopularListener { })
            .apply {
                submitList(listOfPopular)
            }

        _binding?.rcCategories?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
        _binding?.rcPopular?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = popularAdapter
        }
    }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }