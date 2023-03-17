package com.example.wikipedia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikipedia.MainActivity2
import com.example.wikipedia.adapter.ItemEvents
import com.example.wikipedia.adapter.trendAdapter
import com.example.wikipedia.data.PostItems
import com.example.wikipedia.databinding.TrendFragmentBinding

class TrendFragment : Fragment(), ItemEvents {
    lateinit var binding: TrendFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TrendFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataTrend = arrayListOf<PostItems>(

            PostItems(
                "https://s2.uupload.ir/files/murdaugh_family_hovr.jpg",
                "Murdaugh family",
                "American lawyers",
                "The Murdaugh family is a regional dynasty of American lawyers in the Lowcountry of South Carolina. Three members of the family named Randolph Murdaugh consecutively served as circuit solicitor (the individual in charge of prosecuting all criminal cases) in the state's 14th judicial district between 1920 and 2006; the family's prominence lead locals to call the five-county district \"Murdaugh Country\". Randolph Murdaugh Sr. founded the civil litigation firm that is now the Parker Law Group LLP, in 1910, in Hampton, South Carolina, which specializes in personal injury litigation.",
                "+1.8M"
            ),
            PostItems(
                "https://s2.uupload.ir/files/tlou1_gmtp.png",
                "The Last of us",
                "TV Series",
                "The Last of Us is an American post-apocalyptic drama television series created by Craig Mazin and Neil Druckmann for HBO. Based on the 2013 video game developed by Naughty Dog, the series is set in 2023, twenty years into a pandemic caused by a mass fungal infection, which forces its hosts to transform into zombie-like creatures and collapses society. The series follows Joel (Pedro Pascal), a smuggler tasked with escorting the teenage Ellie (Bella Ramsey) across a post-apocalyptic United States. ",
                "+1.3M",
            ),

            PostItems(
                "https://s2.uupload.ir/files/piqsels.com-id-zbxec_bt7y.jpg",
                "Chatgpt",
                "artificial intelligence",
                "ChatGPT[a] is an artificial intelligence chatbot developed by OpenAI and launched in November 2022. It is built on top of OpenAI's GPT-3 family of large language models and has been fine-tuned (an approach to transfer learning) using both supervised and reinforcement learning techniques.\n" +
                        "\n" +
                        "ChatGPT was launched as a prototype on November 30, 2022, and quickly garnered attention for its detailed responses and articulate answers across many domains of knowledge.[3] Its uneven factual accuracy, however, has been identified as a significant drawback.[4] Following the release of ChatGPT, OpenAI's valuation was estimated at US\$29 billion in 2023",
                "+1.1M"
            ),
            PostItems(
                "https://s2.uupload.ir/files/jake_paul_(1)_nzwq.jpg",
                "Jake Paul",
                "American media personality",
                "Jake Joseph Paul (born January 17, 1997)[1] is an American social media personality and professional boxer. He initially rose to fame on Vine,[5] before playing the role of Dirk Mann on the Disney Channel series Bizaardvark for two seasons.[6] Throughout his career, Paul has become the subject of many controversies due to his behavior, including being charged with criminal trespass and unlawful assembly",
                "+750K"
            ),
            PostItems(
                "https://s2.uupload.ir/files/shah_rukh_3als.jpg",
                "Pathaan",
                "Indian Movie",
                "Pathaan is a 2023 Indian Hindi-language action thriller film directed by Siddharth Anand and written by Shridhar Raghavan and Abbas Tyrewala, from a story by Anand. The fourth installment in the YRF Spy Universe, it stars Shah Rukh Khan, Deepika Padukone, John Abraham, Dimple Kapadia, and Ashutosh Rana. In the film, Pathaan (Khan), an exiled RAW agent, works with ISI agent Rubina Mohsin (Padukone) to take down Jim (Abraham), a former RAW agent planning to spread a deadly lab-generated virus across India.",
                "+650K",
            ),
            PostItems(
                "https://s2.uupload.ir/files/mac_mcclung_(cropped)_f9xc.jpg",
                "Mac McClung",
                "American professional basketball player",
                "Matthew \"Mac\" McClung[1] (born January 6, 1999) is an American professional basketball player for the Philadelphia 76ers of the National Basketball Association (NBA), on a two-way contract with the Delaware Blue Coats of the NBA G League. He played college basketball for the Georgetown Hoyas and the Texas Tech Red Raiders. He was a consensus three-star recruit and among the highest-ranked high school players in Virginia. ",
                "+600K",
            ),
            PostItems(
                "https://s2.uupload.ir/files/tommy_fury_5884.jpg",
                "Tom Fury",
                "British professional boxer",
                "Tommy Fury (born 7 May 1999[2]) is a British professional boxer and reality television personality. He took time off from his boxing career in 2019 to star in the fifth series of the ITV2 dating reality television show Love Island. Along with partner Molly-Mae Hague the couple finished as runners-up of the series. He is the younger half-brother of heavyweight world champion of boxing, Tyson Fury. ",
                "+570K"
            ),
            PostItems(
                "https://s2.uupload.ir/files/cocaine_bear_e0h2.jpg",
                "Cocaine bear",
                "American Black Bear",
                "The Cocaine Bear, also known as Pablo Eskobear (sometimes spelled Escobear)[1][2] or Cokey the Bear,[3] was a 175-pound (79-kilogram) American black bear that fatally overdosed on cocaine in 1985. The cocaine had been dropped by drug smugglers in the wilderness in Tennessee, United States. The bear was found dead in northern Georgia and was stuffed and displayed at a mall in Kentucky. It inspired the 2023 comedy horror film Cocaine Bear",
                "+490K"
            )
        )

        val myAdapter = trendAdapter(dataTrend, this)
        binding.trendRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.trendRecycler.adapter = myAdapter
    }

    override fun onItemClicked(postItems: PostItems) {
        val intent = Intent(activity, MainActivity2::class.java)
        intent.putExtra(SEND_DATA_TO_SECOND_ACTIVITY, postItems)
        startActivity(intent)
    }

}