package com.cateim.cursos.android.scrollviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val bodyTextView = findViewById<TextView>(R.id.bodyTextView)

        val noticia = """
            Lewis Hamilton thrilled a crowd of 86,000 at Silverstone to take pole position for Saturday's new sprint race at the British Grand Prix.

            The Mercedes driver beat title rival Max Verstappen's Red Bull by 0.075 seconds to secure top spot for the new 17-lap race introduced this weekend.

            Mercedes' Valtteri Bottas was third ahead of Ferrari's Charles Leclerc.

            McLaren's Lando Norris was sixth and there was an outstanding display by Williams' George Russell in eighth.

            "It has been such a difficult time for everyone and we finally have all the fans at the British Grand Prix and the desire to deliver for everyone is beyond belief," said Hamilton.

            "We watched the England game the other day, you see how much passion there is in England. It was a difficult time for everyone and I was hoping I could do my part in bringing something positive. It is only the first step but, wow, what a fantastic way to end the day."

            How British GP qualifying unfolded
            Qualifying times (external site)
            Verstappen on refusing to dream, dealing with pressure & learning from his dad
            Winning title a 'tall order' - Hamilton
            Vintage Hamilton at Silverstone
            Lewis Hamilton and Valtteri Bottas
            Mercedes looked off the pace of Red Bull earlier on Friday but delivered when it mattered in Friday qualifying
            Hamilton set the time that mattered on his first lap in final qualifying. He was on course for a quicker time on his final run but made a mistake, sliding wide at the penultimate corner, Vale, and losing time.

            But while Verstappen did improve on his final lap, it was not enough to supplant Hamilton and the seven-time world champion sent the crowd into raptures.

            Already this is the biggest crowd at a sporting event in the UK since the start of the pandemic - and there are more to come over the weekend, with 140,000 due to attend the Grand Prix on Sunday in predicted temperatures of close to 30C.

            It was a vintage performance from Hamilton, helped by the Mercedes team's first upgrades since the Spanish Grand Prix in May, but it is not another pole position to add to his tally of 100 - officially the driver who wins Saturday's 'sprint' will be classified as the pole position winner.

            And it was an important change in form after four wins in five races by Verstappen, who has opened a 32-point championship lead.

            The crowd chanted Hamilton's name as he did his post-session interview and he basked in their adulation.

            Hamilton said: "We have been missing this for a whole years, I have lost my voice a little. I am so grateful to see everyone here. To come to Silverstone and have a full crowd like this. You feel the energy. I was hopeful with the great work we did at the team and the energy of the fans would get us here. This is down to the fans.

            "The first lap was great and the second was looking even better but I just lost the back end in the last corner and my heart was in my mouth as I crossed the line."

            Verstappen said: "The car was handling quite well but just a lot of understeer so I couldn't really attack any corners, just waiting for the front to grip up. A weird feeling to drive, I don't think it was set-up or front wing related, we are still quite close so it's all right."

            And the 23-year-old said the new format being trialled this weekend - and planned for a further two races at some point this season - was "a bit of a weird feeling".

            "You do qualifying, you go flat out and it doesn't really mean anything in terms of pole feeling," Verstappen said.

            "We have a strong race car but we need to fix the issues in qualifying. I am quite confident we can have a strong race."

            There are three world championship points on offer for the winner of Saturday's sprint, two for second and one for third, and Hamilton has said he "needs" to win both that event and the Grand Prix to reduce his deficit to Verstappen in the championship.

            Hamilton has the benefit of his team-mate also up in the top three with him, while Verstappen's partner Sergio Perez could manage only fifth in his Red Bull, beaten by the Ferrari of Charles Leclerc, in another stellar qualifying performance by the Monegasque.

            Sprint qualifying: F1's break with history
            British Grand Prix radio & online coverage details
            What a day for the home fans
            Lewis Hamilton
            The Silverstone crowd rose to acclaim Hamilton after he topped the qualifying hour
            It was a day for the always dedicated Silverstone crowd to celebrate both the present and future of British motorsport at the highest level, with all three home drivers in the top 10.

            Norris edged McLaren team-mate Daniel Ricciardo into sixth place, in a welcome return to form for the popular Australian, but the star of the session was Russell.

            The grandstands cheered him mightily as he made it into the top-10 shootout, knocking out two-time world champion Fernando Alonso's Alpine in the process.

            And he did it again in the final session, beating the second Ferrari of Carlos Sainz and four-time champion Sebastian Vettel's Aston Martin to take eighth.

            The crowd cheered as Russell started his lap, cheered him around it, and cheered as he crossed the line to set his time, as a new superstar had clearly been taken to the fans' hearts.


            Report
            And his performance sent a resounding message to Mercedes, who say they have still not yet decided whether to pick Russell or Bottas as partner for Hamilton next season.

            Russell said: "Incredible. Damon Hill [1996 world champion] told me the crowd's worth a second. I thought he was lying but maybe he was right.

            "Incredible support and amazing feeling, second Q3 with Williams on the bounce. We are on this roll at the moment and seeing everyone, everything together. It is just great. Buzzing, to be honest."

            The performance gives Russell another chance to score his first points for Williams, after he was deprived of 10th place by a late pass by Alonso in Austria two weeks ago.

            "It is only Friday," Russell said. "We have a long way to go, but to get into Q3 in front of my home crowd is amazing. We have real chance this weekend and we're going for it."
        """.trimIndent()


        bodyTextView.text = noticia

        //
        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            val uriNoticia = Uri.parse("https://www.bbc.com/sport/formula1/57869578")
            val intent = Intent(Intent.ACTION_VIEW, uriNoticia)

            startActivity(intent)
        }
    }
}