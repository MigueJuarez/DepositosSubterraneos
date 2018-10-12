package depositosSubterraneos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private FileWriter fw;
	private static FileReader fr;
	private static BufferedReader br;
	private BufferedWriter bw;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Deposito> depositos;

		try {

			fr = new FileReader("depositos.in");
			br = new BufferedReader(fr);

			depositos = new ArrayList<Deposito>();
			int cantdepositos = Integer.parseInt(br.readLine());
			int volumen = 0;
			for (int i = 0; i < cantdepositos; i++) {
				String[] lectura = br.readLine().split(" ");
				depositos.add(new Deposito(Integer.valueOf(lectura[0]),Integer.valueOf(lectura[1])));
			}

			volumen = Integer.parseInt(br.readLine());
			int depositosUtilizados = 0;

			for (int i = 0; i < cantdepositos - 1; i++) {

				volumen -= (depositos.get(i).getProfundidad() - depositos.get(i + 1).getProfundidad())
						* depositos.get(i).getDimension();
				depositos.get(i)
						.setVolumenRelativo(depositos.get(i).getVolumen()
								- ((depositos.get(i).getProfundidad() - depositos.get(i + 1).getProfundidad())
										* depositos.get(i).getDimension()));
				if (volumen < 0) {
					depositosUtilizados = i;
					break;
				}
			}
			
			if (volumen > 0) {
				for (int i = 0; i < cantdepositos; i++) {

					volumen -= depositos.get(i).getVolumenRelativo();

					if (volumen < 0) {
						depositosUtilizados = i;
						break;
					}
				}
			}

			if (volumen >= 0) {
				System.out.println("HAY DESBORDE: " + depositosUtilizados);
				System.out.println("VOLUMEN SOBRANTE: " + volumen);

			}
			else {
				System.out.println("NO HAY DESBORDE");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ee) {
			ee.printStackTrace();

		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
		}
	}

}
