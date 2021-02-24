package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public void ip(String sistemaOperacional) {
		try {
			if(sistemaOperacional == "Windows" || sistemaOperacional == "windows") {
				sistemaOperacional = "ipconfig";
			} else if(sistemaOperacional == "Linux" || sistemaOperacional == "linux") {
				sistemaOperacional = "ifconfig";
			}
				Process P = Runtime.getRuntime().exec(sistemaOperacional);
				InputStream fluxo = P.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("IPv4") || linha.contains("Ethernet")) {
					System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ping(String sistemaOperacional) {
		try {
			if(sistemaOperacional == "Windows" || sistemaOperacional == "windows") {
				sistemaOperacional = "ping -4 -n 10 www.uol.com.br";
			} else if(sistemaOperacional == "Linux" || sistemaOperacional == "linux") {
				sistemaOperacional = "ping -4 -c 10 www.uol.com.br";
			}
				Process P = Runtime.getRuntime().exec(sistemaOperacional);
				InputStream fluxo = P.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
