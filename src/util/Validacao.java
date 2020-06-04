/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fdz
 */
public class Validacao {
    
    public static boolean validarCPF(String cpf) throws Exception {

        int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
        int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
        String strDigitoVerificador, strDigitoResultado;

        if (!cpf.substring(0, 1).equals("")) {
            try {
                cpf = cpf.replace('.', ' ');
                cpf = cpf.replace('-', ' ');
                cpf = cpf.replaceAll(" ", "");
                for (int iCont = 1; iCont < cpf.length() - 1; iCont++) {
                    iDigitoCPF = Integer.valueOf(cpf.substring(iCont - 1, iCont)).intValue();
                    iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
                    iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
                }
                iRestoDivisao = (iDigito1Aux % 11);
                if (iRestoDivisao < 2) {
                    iDigito1 = 0;
                } else {
                    iDigito1 = 11 - iRestoDivisao;
                }
                iDigito2Aux += 2 * iDigito1;
                iRestoDivisao = (iDigito2Aux % 11);
                if (iRestoDivisao < 2) {
                    iDigito2 = 0;
                } else {
                    iDigito2 = 11 - iRestoDivisao;
                }
                strDigitoVerificador = cpf.substring(cpf.length() - 2, cpf.length());
                strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
                strDigitoVerificador.equals(strDigitoResultado);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        throw new Exception("cpf Inválido");

    }

    public static boolean validarEmail(String email) throws Exception {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return isEmailIdValid = true;
            }
        }
        throw new Exception("Digite um E-mail Válido");

    }
    
}
