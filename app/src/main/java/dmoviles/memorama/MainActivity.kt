package dmoviles.memorama

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //varuables que se utilizaran en las siguientes funciones
    var errores = 5
    lateinit var ib_sonido:ImageButton
    lateinit var mp:MediaPlayer
    lateinit var mpFondo:MediaPlayer
    var escuchar=true
    lateinit var button: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Encuentra las parejas, solo tienes 5 intentos!!!",
            Toast.LENGTH_SHORT).show()
        tablero()
        restart()
    }

    fun restart(){
        button = findViewById(R.id.imageButton2)
        button.setColorFilter(Color.GREEN)
        button.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)

            if(mpFondo.isPlaying){
                mpFondo.stop()
                mpFondo.release()
            }
        }
    }

    fun tablero(){
        //Variable que cuenta el numero de veces que pulsamos un boton que tiene un signo
        var onClickGeneral = 0
        var seleccionadas:MutableList<cartas> = mutableListOf()

        ib_sonido = findViewById(R.id.ib_sonido)
        ib_sonido.setColorFilter(Color.GREEN)
        sonido("background", true)

        //Iniciamos los botones
        val card1:ImageButton = findViewById(R.id.card1)
        val card2:ImageButton = findViewById(R.id.card2)
        val card3:ImageButton = findViewById(R.id.card3)
        val card4:ImageButton = findViewById(R.id.card4)
        val card5:ImageButton = findViewById(R.id.card5)
        val card6:ImageButton = findViewById(R.id.card6)
        val card7:ImageButton = findViewById(R.id.card7)
        val card8:ImageButton = findViewById(R.id.card8)
        val card9:ImageButton = findViewById(R.id.card9)
        val card10:ImageButton = findViewById(R.id.card10)
        val card11:ImageButton = findViewById(R.id.card11)
        val card12:ImageButton = findViewById(R.id.card12)
        val card13:ImageButton = findViewById(R.id.card13)
        val card14:ImageButton = findViewById(R.id.card14)
        val card15:ImageButton = findViewById(R.id.card15)
        val card16:ImageButton = findViewById(R.id.card16)

        //Valores de las cartas
        var carta1 = cartas(false,R.drawable.crash,card1)
        var carta2 = cartas(false,R.drawable.aku,card2)
        var carta3 = cartas(false,R.drawable.mario,card3)
        var carta4 = cartas(false,R.drawable.sonic,card4)
        var carta5 = cartas(false,R.drawable.spyro,card5)
        var carta6 = cartas(false,R.drawable.kirby,card6)
        var carta7 = cartas(false,R.drawable.clank,card7)
        var carta8 = cartas(false,R.drawable.link,card8)
        var carta9 = cartas(false,R.drawable.link,card9)
        var carta10 = cartas(false,R.drawable.clank,card10)
        var carta11 = cartas(false,R.drawable.kirby,card11)
        var carta12 = cartas(false,R.drawable.spyro,card12)
        var carta13 = cartas(false,R.drawable.sonic,card13)
        var carta14 = cartas(false,R.drawable.mario,card14)
        var carta15 = cartas(false,R.drawable.aku,card15)
        var carta16 = cartas(false,R.drawable.crash,card16)

        //Creamos lista mutable
        var listaCartas:MutableList<cartas> = mutableListOf()

        listaCartas.add(carta1)
        listaCartas.add(carta2)
        listaCartas.add(carta3)
        listaCartas.add(carta4)
        listaCartas.add(carta5)
        listaCartas.add(carta6)
        listaCartas.add(carta7)
        listaCartas.add(carta8)
        listaCartas.add(carta9)
        listaCartas.add(carta10)
        listaCartas.add(carta11)
        listaCartas.add(carta12)
        listaCartas.add(carta13)
        listaCartas.add(carta14)
        listaCartas.add(carta15)
        listaCartas.add(carta16)


        //Escojemos la posicion de las imagenes en forma aleatoria
        val n = List(16) { Random.nextInt(0, 15) }


        listaCartas[0].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[0].buton.setBackgroundResource(listaCartas[0].img)
                onClickGeneral++
                listaCartas[0].buton.isEnabled=false
                seleccionadas.add(listaCartas[0])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    //ya no tiene oportunidad de jugar
                    //return false
                }
                
            }
        }
        listaCartas[1].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[1].buton.setBackgroundResource(listaCartas[1].img)
                onClickGeneral++
                listaCartas[1].buton.isEnabled=false
                seleccionadas.add(listaCartas[1])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[2].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[2].buton.setBackgroundResource(listaCartas[2].img)
                onClickGeneral++
                listaCartas[2].buton.isEnabled=false
                seleccionadas.add(listaCartas[2])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[3].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[3].buton.setBackgroundResource(listaCartas[3].img)
                onClickGeneral++
                listaCartas[3].buton.isEnabled=false
                seleccionadas.add(listaCartas[3])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[4].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[4].buton.setBackgroundResource(listaCartas[4].img)
                onClickGeneral++
                listaCartas[4].buton.isEnabled=false
                seleccionadas.add(listaCartas[4])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[5].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[5].buton.setBackgroundResource(listaCartas[5].img)
                onClickGeneral++
                listaCartas[5].buton.isEnabled=false
                seleccionadas.add(listaCartas[5])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[6].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[6].buton.setBackgroundResource(listaCartas[6].img)
                onClickGeneral++
                listaCartas[6].buton.isEnabled=false
                seleccionadas.add(listaCartas[6])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[7].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[7].buton.setBackgroundResource(listaCartas[7].img)
                onClickGeneral++
                listaCartas[7].buton.isEnabled=false
                seleccionadas.add(listaCartas[7])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[8].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[8].buton.setBackgroundResource(listaCartas[8].img)
                onClickGeneral++
                listaCartas[8].buton.isEnabled=false
                seleccionadas.add(listaCartas[8])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[9].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[9].buton.setBackgroundResource(listaCartas[9].img)
                onClickGeneral++
                listaCartas[9].buton.isEnabled=false
                seleccionadas.add(listaCartas[9])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[10].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[10].buton.setBackgroundResource(listaCartas[10].img)
                onClickGeneral++
                listaCartas[10].buton.isEnabled=false
                seleccionadas.add(listaCartas[10])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[11].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[11].buton.setBackgroundResource(listaCartas[11].img)
                onClickGeneral++
                listaCartas[11].buton.isEnabled=false
                seleccionadas.add(listaCartas[11])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[12].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[12].buton.setBackgroundResource(listaCartas[12].img)
                onClickGeneral++
                listaCartas[12].buton.isEnabled=false
                seleccionadas.add(listaCartas[12])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[13].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[13].buton.setBackgroundResource(listaCartas[13].img)
                onClickGeneral++
                listaCartas[13].buton.isEnabled=false
                seleccionadas.add(listaCartas[13])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{
                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[14].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[14].buton.setBackgroundResource(listaCartas[14].img)
                onClickGeneral++
                listaCartas[14].buton.isEnabled=false
                seleccionadas.add(listaCartas[14])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{

                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
        listaCartas[15].buton.setOnClickListener {
            //Comparamos que cuantas veces a pulsado un boton
            if (onClickGeneral < 2 && errores>0){
                listaCartas[15].buton.setBackgroundResource(listaCartas[15].img)
                onClickGeneral++
                listaCartas[15].buton.isEnabled=false
                seleccionadas.add(listaCartas[15])
                sonido("touch")
            }else{
                if(errores>0){
                    verificar(seleccionadas[0],seleccionadas[1])
                    seleccionadas.clear()
                    onClickGeneral=0
                }else{

                    Toast.makeText(this, "UYYY!! ya perdiste :(", Toast.LENGTH_SHORT).show()
                    mpFondo.stop()
                    sonido("no")
                    //ya no tiene oportunidad de jugar
                    //return false
                }
            }
        }
    }

    fun verificar(cSeleccionada1:cartas,cSeleccionada2:cartas):Boolean {
        if (cSeleccionada1.img == cSeleccionada2.img) {
            Toast.makeText(this, "Genial, lo encontraste", Toast.LENGTH_SHORT).show()
            cSeleccionada1.estado = true
            cSeleccionada2.estado = true
            sonido("success")
            return true
        } else {
            errores--
            Toast.makeText(this, "Fallaste, te quedan " + errores + " intentos", Toast.LENGTH_SHORT)
                .show()
            cSeleccionada1.buton.setBackgroundResource(R.drawable.bg)
            cSeleccionada2.buton.setBackgroundResource(R.drawable.bg)
            //Regresamos las imagenes para ocultar
            cSeleccionada1.buton.isEnabled = true
            cSeleccionada2.buton.isEnabled = true
            sonido("nop")
            return false
        }

    }

    fun musicaFondo(v: View) {
        if (escuchar) {
            mpFondo.pause()
            ib_sonido.setImageResource(R.drawable.ic_volumen_off)
            ib_sonido.setColorFilter(Color.GRAY)
        } else {
            mpFondo.start()
            ib_sonido.setImageResource(R.drawable.ic_volume_on)
            ib_sonido.setColorFilter(Color.GREEN)
        }
        escuchar = !escuchar
    }

    private fun sonido(sonidoName: String, loop: Boolean = false) {
        var resID = resources.getIdentifier(
            sonidoName, "raw", packageName
        )
        if (sonidoName == "background") {
            mpFondo = MediaPlayer.create(this,resID)
            mpFondo.isLooping = loop
            mpFondo.setVolume(0.04F, 0.04F)
            if (!mpFondo.isPlaying) {
                mpFondo.start()
            }
        } else {
            mp = MediaPlayer.create(this, resID)
            mp.setOnCompletionListener(MediaPlayer.OnCompletionListener { mediaPlayer ->
                mediaPlayer.stop()
                mediaPlayer.release()
            })
            if (!mp.isPlaying) {
                mp.start()
            }
        }
    }
}

data class cartas(var estado:Boolean, var img:Int,var buton:ImageButton)