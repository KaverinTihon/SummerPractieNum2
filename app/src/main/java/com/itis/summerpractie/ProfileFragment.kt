package com.itis.summerpractie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.summerpractie.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding?.run{
            btnToSpace.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_spaceFragment)
            }
        }

        val name = arguments?.getString(ARG_NAME)
        Log.e("ProfileFragment", name.orEmpty())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_AGE = "ARG_AGE"

        fun createBundle(name: String, age: Int): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            bundle.putInt(ARG_AGE, age)
            return bundle
        }
    }
}
