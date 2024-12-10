package com.example.ejemploreceptorintents

import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemploreceptorintents.databinding.ActivityAgregarEventoCalendarioBinding
import java.security.Timestamp
import java.time.Instant
import java.time.ZoneId
import java.util.Date

class AgregarEventoCalendario : AppCompatActivity() {
    lateinit var mibinding:ActivityAgregarEventoCalendarioBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding=ActivityAgregarEventoCalendarioBinding.inflate(layoutInflater)
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recibo los datos del evento calendario
        //Ejercicio, finalizar el layout para mostrar toda la información que proviene de
        //la intención que inicia esta actividad
        val fecha_inicio=Instant.ofEpochMilli(intent.getLongExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 0)).atZone(ZoneId.systemDefault()).toLocalDateTime()
        val fecha_fin=Instant.ofEpochMilli(intent.getLongExtra(CalendarContract.EXTRA_EVENT_END_TIME, 0)).atZone(ZoneId.systemDefault()).toLocalDateTime()


        mibinding.tituloTView.text = intent.getStringExtra(CalendarContract.Events.TITLE)
        mibinding.descTView.text = intent.getStringExtra(CalendarContract.Events.DESCRIPTION)
        mibinding.inicioTView.text = "Inicio: ${fecha_inicio.dayOfMonth}-${fecha_inicio.month}-${fecha_inicio.year}  ${fecha_inicio.hour}:${fecha_inicio.minute}:${fecha_inicio.second}"
        mibinding.finTView.text = "Fin: ${fecha_fin.dayOfMonth}-${fecha_fin.month}-${fecha_fin.year}  ${fecha_fin.hour}:${fecha_fin.minute}:${fecha_fin.second}"


    }
}