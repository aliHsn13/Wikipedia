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
import com.example.wikipedia.adapter.exploreAdapter
import com.example.wikipedia.data.PostItems
import com.example.wikipedia.databinding.ExploreFragmentBinding

const val SEND_DATA_TO_SECOND_ACTIVITY = "sendData"


class ExploreFragment : Fragment(), ItemEvents {
    lateinit var binding: ExploreFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExploreFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arrayListOf<PostItems>(

            PostItems(
                "https://s2.uupload.ir/files/beatrice_arthur_x6ks.jpg",
                "Bea Arthur",
                "American actress",
                "Beatrice Arthur was an American actress and comedian. Born and raised in Brooklyn, New York City, Arthur began her career on stage in 1947, attracting critical acclaim before achieving worldwide recognition for her work on television beginning in the 1970s as Maude Findlay in the popular sitcoms All in the Family (1971–1972) and Maude (1972–1978) and later in the 1980s and 1990s as Dorothy Zbornak on The Golden Girls (1985–1992). ",
                "+500K"
            ),
            PostItems(
                "https://s2.uupload.ir/files/zelensky_b0kg.jpg",
                "Volodymyr Zelenskyy",
                "President of Ukraine",
                "Volodymyr Oleksandrovych Zelenskyy is a Ukrainian politician and former comedian and actor who has served as the sixth and current president of Ukraine since 2019. Born to a Ukrainian Jewish family, Zelenskyy grew up as a native Russian speaker in Kryvyi Rih, a major city of Dnipropetrovsk Oblast in central Ukraine. Prior to his acting career, he obtained a degree in law from the Kyiv National Economic University. He then pursued a career in comedy and created the production company Kvartal 95, which produced films, cartoons, and TV shows including the TV series Servant of the People, in which Zelenskyy played the role of the Ukrainian president. The series aired from 2015 to 2019 and was immensely popular. A political party bearing the same name as the television show was created in March 2018 by employees of Kvartal 95. ",
                "+1M",
            ),
            PostItems(
                "https://s2.uupload.ir/files/battleofaslundoz_n8ea.jpg",
                "Battle of Aslanduz",
                "Russo-Persian War",
                "The Battle of Aslanduz took place from 31 October to 1 November 1812 between Russian Empire and Qajar Iran during the Russo-Persian War (1804-1813). The Persian commander Fath Ali Shah stationed his forces, led by his two heirs, Abbas Mirza and Dowlatshah, in Aslanduz. Russian forces under the command of Major General Pyotr Kotlyarevsky launched a surprise night attack and routed the Persians, who were still sleeping. Kotlyarevsky then quickly moved on to storm Lankaran successfully in early 1813 which ended any Persian hope of continuing the war or settling on a stalemate for both parties The Persian suffered heavy casualties numbering around 2,000 killed and 500 captured. The Russians lost 28 men with 99 wounded. Among those killed during the battle was Charles Christie, a British officer in the service of Iran. ",
                "+120K"
            ),

            PostItems(
                "https://s2.uupload.ir/files/maluma_la4e.jpg",
                "Maluma",
                "Colombian singer",
                "Juan Luis Londoño Arias (born 28 January 1994), known professionally as Maluma, is a Colombian singer, songwriter, and actor.\n" +
                        "Born and raised in Medellín, he developed an interest in music at a young age, recording songs since age sixteen. He released his debut album, Magia, a year later in 2012. But, his breakthrough album was 2015's Pretty Boy, Dirty Boy, which led to successful collaborations with many artists. He released F.A.M.E. in 2018, another commercial success. He followed it with 11:11 in 2019, and Papi Juancho, released without further announcement in 2020. His single Hawái reached number three on the Billboard Global 200, and became the first number one single on the Billboard Global Excl. U.S. chart. Selling more than 18 million records (albums and singles), Maluma is one of the best-selling Latin music artists.[2] Musically, Maluma's songs have been described as reggaeton, Latin trap, and pop. Maluma has a number of singles that have charted within the top ten on Billboard Hot Latin Songs, including Felices los 4, Borró Cassette, and Corazón. His collaborative efforts Chantaje with Shakira and Medellín with Madonna have reached the top of the Hot Latin Songs and the Dance Club Songs chart, respectively. He has worked with other international artists, such as Jennifer Lopez, Ricky Martin, J Balvin, and The Weeknd. Maluma has won a Latin Grammy Award, an MTV Video Music Award, two Latin American Music Awards, and been nominated for a Grammy Award for Best Latin Pop Album.",
                "+950K"
            ),
            PostItems(
                "https://s2.uupload.ir/files/bulgakov_ifvk.jpg",
                "Mikhail Bulgakov",
                "Russian-Soviet writer",
                "Mikhail Afanasyevich Bulgakov was a Russian, later Soviet writer, medical doctor, and playwright active in the first half of the 20th century.[1] He is best known for his novel The Master and Margarita, published posthumously, which has been called one of the masterpieces of the 20th century. He is also known for his novel The White Guard; his plays Ivan Vasilievich, Flight (also called The Run), and The Days of the Turbins; and other works of the 1920s and 1930s. He wrote mostly about the horrors of the Russian Civil War and about the fate of Russian intellectuals and officers of the Tsarist Army caught up in revolution and Civil War. Some of his works (Flight, all his works between the years 1922 and 1926, and others) were banned by the Soviet government, and personally by Joseph Stalin, after it was decided by them that they glorified emigration and White generals On the other hand, Stalin loved The Days of the Turbins (also called The Turbin Brothers) very much and reportedly saw it at least 15 times",
                "+840K"
            ),
            PostItems(
                "https://s2.uupload.ir/files/tbbtcast(1)_beo1.jpg",
                "The Big Bang Theory",
                "2007 ‧ Sitcom ‧ 12 seasons",
                "The Big Bang Theory is an American television sitcom created by Chuck Lorre and Bill Prady, both of whom served as executive producers on the series, along with Steven Molaro. The three of them also served as head writers. It premiered on CBS on September 24, 2007, and concluded on May 16, 2019, having broadcast 279 episodes over 12 seasons.The show originally centered on five characters living in Pasadena, California: Leonard Hofstadter (Johnny Galecki) and Sheldon Cooper (Jim Parsons), both physicists at Caltech, who share an apartment; Penny (Kaley Cuoco), a waitress and aspiring actress who lives across the hall; and Leonard and Sheldon's similarly geeky and socially awkward friends and coworkers, aerospace engineer Howard Wolowitz (Simon Helberg) and astrophysicist Raj Koothrappali (Kunal Nayyar).[4][5] Over time, supporting characters were promoted to starring roles, including neuroscientist Amy Farrah Fowler (Mayim Bialik), microbiologist Bernadette Rostenkowski (Melissa Rauch), and comic book store owner Stuart Bloom (Kevin Sussman). ",
                "+197M",
            )
        )

        val myAdapter = exploreAdapter(data, this)
        binding.exploreRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.exploreRecycler.adapter = myAdapter
    }

    override fun onItemClicked(postItems: PostItems) {
        val intent = Intent(activity , MainActivity2::class.java)
        intent.putExtra( SEND_DATA_TO_SECOND_ACTIVITY , postItems )
        startActivity( intent )
    }
}