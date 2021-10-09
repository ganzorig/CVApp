package com.miu.curriculumvitae.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.miu.curriculumvitae.R
import com.miu.curriculumvitae.common.Education
import com.miu.curriculumvitae.common.FlowLayout
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.fragment_work.view.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_small.view.*

class WorkFragment : Fragment() {
    private val KEY = "person"
    private lateinit var person: Person

    fun newInstance(person: Person): WorkFragment {
        val args = Bundle()
        val fragment = WorkFragment()
        args.putSerializable(KEY, person)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_work, container, false)
        person = arguments?.getSerializable(KEY) as Person

        val workParent = view.findViewById<LinearLayout>(R.id.works)
        val projectParent = view.findViewById<LinearLayout>(R.id.projects)
        val skillParent = view.findViewById<FlowLayout>(R.id.skills)

        for (wr in person.works) {
            val item = inflater.inflate(R.layout.item, container, false)
            item.title.text = wr.position
            item.place.text = wr.companyName
            item.year.text = wr.betweenYear
            workParent.addView(item)
        }
        for (pr in person.projects) {
            val item = inflater.inflate(R.layout.item, container, false)
            item.title.text = pr.projectTitle
            item.place.text = pr.Contribution
            item.year.text = pr.betweenYear
            projectParent.addView(item)
        }
        for (sk in person.skills) {
            val item = inflater.inflate(R.layout.item_small, container, false)
            item.item_txtView.text = sk
            skillParent.addView(item)
        }

        view.fab.setOnClickListener {
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", View.OnClickListener {
                    Toast.makeText(context, "Hi", Toast.LENGTH_SHORT).show()
                })
                .show()

                val item = inflater.inflate(R.layout.item_small, container, false)
                item.item_txtView.text = "sk"
                skillParent.addView(item)
        }
        return view
    }



}
