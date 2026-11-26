package util;

public final class Validador {

    private Validador() {
    }

    public static boolean validarCnpj(String cnpj) {
        if (cnpj == null || cnpj.contains(";")) {
            return false;
        }

        String c = cnpj.toUpperCase().replaceAll("[./\\-\\s]", "");

        if (!c.matches("[0-9A-Z]{12}[0-9]{2}")) {
            return false;
        }
        if (c.chars().distinct().count() == 1) {
            return false;
        }

        int[] pesosDv1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesosDv2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += (c.charAt(i) - 48) * pesosDv1[i];
        }
        int resto = soma % 11;
        int dv1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += (c.charAt(i) - 48) * pesosDv2[i];
        }
        soma += dv1 * pesosDv2[12];
        resto = soma % 11;
        int dv2 = (resto < 2) ? 0 : 11 - resto;

        return (c.charAt(12) - '0') == dv1 && (c.charAt(13) - '0') == dv2;
    }

    public static boolean validarEmail(String email) {
        if (email == null || email.contains(";")) {
            return false;
        }
        return !email.isBlank() && email.contains("@");
    }

    public static boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.contains(";")) {
            return false;
        }
        String tel = somenteDigitos(telefone);
        return tel.length() == 10 || tel.length() == 11;
    }

    private static String somenteDigitos(String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replaceAll("\\D", "");
    }
}