package cl.uct.cedest.conteocelulas.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import cl.uct.cedest.conteocelulas.Model.CaracteristicaHematies
import cl.uct.cedest.conteocelulas.Model.CaracteristicaLeucocitos
import cl.uct.cedest.conteocelulas.Model.CaracteristicaPlaquetas
import cl.uct.cedest.conteocelulas.Model.Conteo
import cl.uct.cedest.conteocelulas.Model.Paciente
import cl.uct.cedest.conteocelulas.R
import cl.uct.cedest.conteocelulas.Utilities.*
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import kotlinx.android.synthetic.main.activity_resultado_final.*
import java.io.FileOutputStream


class ResultadoFinalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_final)

        initResultadosPacienteCaracteristicas()

        intiResultadoConteo()
        //toPDF()

    }

    fun  initResultadosPacienteCaracteristicas(){
        val paciente = intent.getParcelableExtra<Paciente>(EXTRA_PACIENTE)
        tipoPacienteTxt.setText(paciente.tipo.capitalize())
        if( !paciente.tipo.equals("adulto")){

            when(paciente.edad){
                0 -> edadPacienteTxt.setText("Recien Nacido")
                1 -> edadPacienteTxt.setText("1 - 12 Meses")
                4 -> edadPacienteTxt.setText("1 - 4 Años")
                16 -> edadPacienteTxt.setText("5 - 16 Años")
            }
        }

        vcmConsTxt.setText("${paciente.vcm} [fL]")
        hcmConsTxt.setText("${paciente.hcm} [pg]")
        chcmConsTxt.setText("${paciente.chcm} %")
        edeConsTxt.setText("${paciente.ede} %")




        val plaquetas  = intent.getParcelableExtra<CaracteristicaPlaquetas>(EXTRA_PLAQUETAS)
        val leucocitos = intent.getParcelableExtra<CaracteristicaLeucocitos>(EXTRA_LEUCOCITOS)
        val hematies   = intent.getParcelableExtra<CaracteristicaHematies>(EXTRA_HEMATIES)

        leucocitosTxt.setText("${leucocitos.caracteristica}")

        microcitosisTxt.setText("${hematies.microcitosis}+")
        macrocitosisTxt.setText("${hematies.macrocitosis}+")
        anisocromiaTxt.setText("${hematies.anisocromia}+")
        hipocromiaTxt.setText("${hematies.hipocromia}+")

        aumentadasTxt.setText("${plaquetas.aumentadas}+")
        disminuidasTxt.setText("${plaquetas.disminuidas}+")
        if(plaquetas.macroplaquetas==0 && plaquetas.microplaquetas==0){
            plaquetasCaracTitleTxt.setText("Normales al frotis")
        }
        if (plaquetas.macroplaquetas==1){
            plaquetasCaracTitleTxt.setText("Macroplaquetas")
        }
        if (plaquetas.microplaquetas == 1){
            plaquetasCaracTitleTxt.setText("Microplaquetas")
        }
        if (plaquetas.microplaquetas==1 && plaquetas.macroplaquetas==1){
            plaquetasCaracTitleTxt.setText("Macroplaquetas -  Microplaquetas")
        }


    }

    fun intiResultadoConteo(){
        val conteo = intent.getParcelableExtra<Conteo>(EXTRA_CONTEO)

        basofiloConteoTxt.setText("${conteo.basofilo}%")
        eosinofiloConteoTxt.setText("${conteo.eosinofilo}%")
        mielocitoConteoTxt.setText("${conteo.mielocitos}%")
        juvenilesConteoTxt.setText("${conteo.juveniles}%")
        baciliformesConteoTxt.setText("${conteo.baciliforme}%")
        segmentadosConteoTxt.setText("${conteo.segmentados}%")
        linfocitosConteoTxt.setText("${conteo.linfocitos}%")
        monocitosConteoTxt.setText("${conteo.monocito}%")

        linfoblastoConteoTxt.setText("${conteo.linfoblastos}%")
        linfocitoReactivoConteoTxt.setText("${conteo.linfocitoReactivo}%")
        prolinfocitoConteoTxt.setText("${conteo.prolinfocito}%")

        monoblastoConteoTxt.setText("${conteo.monoblasto}%")
        promonocitoConteoTxt.setText("${conteo.promonocito}%")

        megacarioblastoConteoTxt.setText("${conteo.megacarioblasto}%")
        megacariocitoConteoTxt.setText("${conteo.megacariocito}%")
        micromegacariocitoConteoTxt.setText("${conteo.micromegacariocito}%")
        micromegacarioblastoConteoTxt.setText("${conteo.micromegacarioblasto}%")

        eritroblastoBasofiloConteoTxt.setText("${conteo.eritoblastoBasofilo}%")
        eritroblastoOrtocromaticoConteoTxt.setText("${conteo.eritoblastoOrtocromatico}%")
        eritroblastoPolicromaticoConteoTxt.setText("${conteo.eritoblastoPolicromatico}%")
    }

    fun toPDF(){

        var document = Document()
        var file = Environment.getExternalStorageDirectory().path + "/hola.pdf"

        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!$file")

        PdfWriter.getInstance(document,FileOutputStream(file))

        //PdfWriter.getInstance(document,new FileOutputStream(file));
        document.open();
        var p = Paragraph("HOLA HOLA HOLA")
        document.add(p);
        document.close();



    }

}
