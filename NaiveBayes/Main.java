import java.util.*;
public class Main {
    public static void main(String[] args){
        /*
            Datos
         */
        List<String> sexo = new ArrayList<>();
        sexo.add("hombre");
        sexo.add("hombre");
        sexo.add("hombre");
        sexo.add("hombre");
        sexo.add("mujer");
        sexo.add("mujer");
        sexo.add("mujer");
        sexo.add("mujer");
        List<Float> altura = new ArrayList<>();
        altura.add(6.0f);
        altura.add(5.92f);
        altura.add(5.58f);
        altura.add(5.92f);
        altura.add(5.0f);
        altura.add(5.5f);
        altura.add(5.42f);
        altura.add(5.75f);
        List<Float> peso = new ArrayList<>();
        peso.add(180.0f);
        peso.add(190.0f);
        peso.add(170.0f);
        peso.add(165.0f);
        peso.add(100.0f);
        peso.add(150.0f);
        peso.add(130.0f);
        peso.add(150.0f);
        List<Float> piesT = new ArrayList<>();
        piesT.add(12.0f);
        piesT.add(11.0f);
        piesT.add(12.0f);
        piesT.add(10.0f);
        piesT.add(6.0f);
        piesT.add(8.0f);
        piesT.add(7.0f);
        piesT.add(9.0f);
        List<List> data = new ArrayList<>();
        data.add(sexo);
        data.add(altura);
        data.add(peso);
        data.add(piesT);
        /*
            Datos a evaluar en un objeto persona.
         */
        Persona p1 = new Persona(6.0f, 130.0f, 8.0f);

        /*
            Contar el número de hombres y mujeres
            numeroH: número de hombres
            numeroM: número de mujeres
            totalR: número total de registros
         */
        int numeroH = 0;
        int numeroM = 0;
        int totalR = 0;

        for(int i = 0; i < data.get(0).size(); i++){
            if(data.get(0).get(i) == "hombre"){
                numeroH +=1;
            }
            else if(data.get(0).get(i) == "mujer"){
                numeroM +=1;
            }
            totalR +=1;
        }
        System.out.println("Numero de hombres: " + numeroH);
        System.out.println("Numero de mujeres: " + numeroM);
        System.out.println("Total de registros: " + totalR);

        /*
            Probabilidad de hombre y mujer
         */
        float probH = (float)numeroH / totalR;
        System.out.println("Probabilidad de que sea hombre: " + probH);
        float probM = (float)numeroM / totalR;
        System.out.println("Probabilidad de que sea mujer: " + probM);

        /*
            Datos separado por parámetro y por género.
         */
        List<Float> alturaH = new ArrayList<>();
        List<Float> pesoH = new ArrayList<>();
        List<Float> piesTH = new ArrayList<>();
        List<Float> alturaM = new ArrayList<>();
        List<Float> pesoM = new ArrayList<>();
        List<Float> piesTM = new ArrayList<>();

        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).size(); j++){
                if(data.get(0).get(j) == "hombre" && i == 1) {
                    alturaH.add((float) data.get(1).get(j));
                }
                if(data.get(0).get(j) == "hombre" && i == 2) {
                    pesoH.add((float)data.get(2).get(j));
                }
                if(data.get(0).get(j) == "hombre" && i == 3) {
                    piesTH.add((float)data.get(3).get(j));
                }
                if(data.get(0).get(j) == "mujer" && i == 3) {
                    alturaM.add((float)data.get(1).get(j));
                }
                if(data.get(0).get(j) == "mujer" && i == 3) {
                    pesoM.add((float)data.get(2).get(j));
                }
                if(data.get(0).get(j) == "mujer" && i == 3) {
                    piesTM.add((float)data.get(3).get(j));
                }
            }
        }

        /*
            Calcular varianza y media para cada uno de los anteriores
         */

        float mediaAltH = calcularMedia(alturaH);
        System.out.println("mediaAltH " + mediaAltH);
        float mediaPesH = calcularMedia(pesoH);
        System.out.println("mediaPesH " + mediaPesH);
        float mediaPTH = calcularMedia(piesTH);
        System.out.println("mediaPTH " + mediaPTH);
        float varAltH = calcularVarianza(alturaH);
        System.out.println("varAltH " + varAltH);
        float varPesH = calcularVarianza(pesoH);
        System.out.println("varPesH " + varPesH);
        float varPTH = calcularVarianza(piesTH);
        System.out.println("varPTH " + varPTH);

        float mediaAltM = calcularMedia(alturaM);
        System.out.println("mediaAltM  " + mediaAltM);
        float mediaPesM = calcularMedia(pesoM);
        System.out.println("mediaPesM " +  mediaPesM);
        float mediaPTM = calcularMedia(piesTM);
        System.out.println("mediaPTM " + mediaPTM);
        float varAltM = calcularVarianza(alturaM);
        System.out.println("varAltM" + varAltM);
        float varPesM = calcularVarianza(pesoM);
        System.out.println("varPesM " + varPesM);
        float varPTM = calcularVarianza(piesTM);
        System.out.println("varPTM " + varPTM);

        /*
            Se crea un objeto Persona, a la cuál se evaluará la probabilidad de que sea hombre dado sus atributos
         */
        Persona persona = new Persona(6.0f, 130.0f, 8.0f);
        float p_alt_H = p_x_dado_y(persona.getAltura(), mediaAltH, varAltH);
        float p_peso_H = p_x_dado_y(persona.getPeso(), mediaPesH, varPesH);
        float p_PTH = p_x_dado_y(persona.getPiesT(), mediaPTH, varPTH);


        System.out.println("La probabilida de que la persona " + persona.toString() + "sea hombre es: ");
        float pFinalH = probH*p_alt_H*p_peso_H*p_PTH;
        System.out.println(pFinalH);

        /*
            Evaluando los mismos datos para calcular la probabilidad de que esta misma persona sea mujer
         */
        float p_alt_M = p_x_dado_y(persona.getAltura(), mediaAltM, varAltM);
        float p_peso_M = p_x_dado_y(persona.getPeso(), mediaPesM, varPesM);
        float p_PTM = p_x_dado_y(persona.getPiesT(), mediaPTM, varPTM);

        System.out.println("La probabilida de que la persona " + persona.toString() + "sea mujer es: ");
        float pFinalM = probM*p_alt_M*p_peso_M*p_PTM;
        System.out.println(pFinalM);

    }
    /*
    Método para calcular la media de valores en una lista de floats.
    Recibe la lista como parámetro.
 */
    static float calcularMedia(List<Float> datos) {
        int tamaño = datos.size();
        float sum = 0.0f;
        for(float a : datos)
            sum += a;
        return sum/tamaño;
    }

    /*
        Método para calcular la varianza de valores en una lista de floats.
        Recibe la lista como parémetro.
     */
    static float calcularVarianza(List<Float> datos) {
        float tamaño = datos.size();
        float media = calcularMedia(datos);
        float temp = 0;
        for(float a : datos) {
            temp += (a - media) * (a - media);
        }
        return temp/(tamaño-1);
    }
    /*
        Método para calcular la probabilidad de un evento dado otro.
     */
    static float p_x_dado_y(float x, float mediaY, float varY){
        float p = 0.0f;
        float a = (float)(Math.sqrt(2*Math.PI*varY));
        float b = (float)(- Math.pow(x-mediaY, 2));
        float c = (float)Math.exp( b / (2*varY));
        p = (1 / a * c );
        return p;
    }


}
