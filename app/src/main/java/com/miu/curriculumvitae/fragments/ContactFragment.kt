package com.miu.curriculumvitae.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.miu.curriculumvitae.R

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_contact, container, false)

        var phone = view.findViewById<LinearLayout>(R.id.phone)
        phone.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:3414003070"));
                startActivity(intent);
            }
        })

        var gmail = view.findViewById<LinearLayout>(R.id.gmail)
        gmail.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val uriText = "mailto:enkhuul999@gmail.com" +
                        "?subject=" + Uri.encode("Hello From MDP Maharishi") +
                        "&body=" + Uri.encode("Hello Enkhee!")

                val uri = Uri.parse(uriText)

                val sendIntent = Intent(Intent.ACTION_SENDTO)
                sendIntent.data = uri
                startActivity(Intent.createChooser(sendIntent, "Send email"))
            }
        })

        var facebook = view.findViewById<LinearLayout>(R.id.facebook)
        facebook.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                try {
                    var intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/enkhee.hana10"));
                    startActivity(intent);
                } catch (e: Exception) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://www.facebook.com/enkhee.hana10")
                        )
                    );
                }
            }
        })
        var twitter = view.findViewById<LinearLayout>(R.id.twitter)
        twitter.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                try {
                    var intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=enkhee21571517"));
                    startActivity(intent);
                } catch (e: Exception) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/#!/enkhee21571517")
                        )
                    );
                }
            }
        })
        var instagram = view.findViewById<LinearLayout>(R.id.instagram)
        instagram.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                try {
                    var intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/enkhuul88"));
                    startActivity(intent);
                } catch (e: Exception) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/enkhuul88")
                        )
                    );
                }
            }
        })
        return view
    }

}
