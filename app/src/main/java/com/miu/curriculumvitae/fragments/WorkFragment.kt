package com.miu.curriculumvitae.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.miu.curriculumvitae.R
import kotlinx.android.synthetic.main.fragment_work.view.*

class WorkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_work, container, false)
        view.fab.setOnClickListener {
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", View.OnClickListener {
                    Toast.makeText(context, "Hi", Toast.LENGTH_SHORT).show()
                })
                .show()
        }
        return view
    }


}
