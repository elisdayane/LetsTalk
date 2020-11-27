package br.com.elis.letstalk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

//to-do - colocar icone
//to-do - fazer lista com itens do shared preferences - é possivel?
//to-do gravar frases em shared preferences
//to-do botao adicionar pergunta main
//to-do criar pagina cadastro de pergunta com opcao de voltar pro jogo
//to-do - botão fechar
//to-do procurar icones bonitinhos e cores que combinam

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var index2 = 0 //variavel utilizada para evitar repeticao de frase seguidas

        //chamando frase no botão
        btnMainRandon.setOnClickListener {

            var listaPergunta = listOf(
                "Se você pudesse ter um superpoder, qual seria? E porque?",
                "O que é um dia perfeito pra você?",
                "Você acredita que dinheiro não é tudo na vida?",
                "Qual a conquista que te deixa mais orgulhose?",
                "Quais as três coisas que te deixa mais feliz atualmente?",
                "O que você não mudaria na sua vida?",
                "De qual grupo você gostaria de fazer parte?",
                "Qual o ultimo show que você assistiu?",
                "Você prefere nunca mais ouvir musica ou nunca mais sentir gosto de doce?",
                "Qual a maior lição de vida que você ja aprendeu?"
            )

            val totalLista = listaPergunta.size

            fun IntRange.random() =
                Random().nextInt((endInclusive + 1) - start) + start
            var index = (0..totalLista-1).random()

            if (index == index2)
            {
                do
                {
                    index = (0..totalLista-1).random()

                }   while(index == index2)
            }


            txvMainPergunta.text = listaPergunta[index]

            index2 = index

        }

        btnMainAddPerg.setOnClickListener {
            val mIntent = Intent(this, AddPergActivity::class.java)
            startActivity(mIntent)
        }

        btnMainSair.setOnClickListener {
            //criar alert dialogue
            AlertDialog.Builder(this)
                .setTitle("Atenção!")
                .setMessage("Deseja mesmo sair?")
                .setPositiveButton("Sair") { _, _ -> //funcao lambda - pesquise
                    finishAffinity()
                }
                .setNeutralButton("Não") { _, _ -> } //fecha  alert automaticamente, sem passar parametro
                .setCancelable(true) //se clica fora do alert, ele fecha
                .show() //mostra o alert
        }
    }
}

