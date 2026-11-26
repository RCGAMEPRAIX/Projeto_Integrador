package util;

public final class Validador {

    private static final int[] PESOS_DV1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] PESOS_DV2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private Validador() {
    }

    public static boolean validarCnpj(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        String c = removerMascara(cnpj);

        if (!c.matches("[0-9A-Z]{12}[0-9]{2}")) {
            return false;
        }
        if (c.chars().distinct().count() == 1) {
            return false;
        }

        String base = c.substring(0, 12);
        int dv1 = calcularDigito(base, PESOS_DV1);
        int dv2 = calcularDigito(base + dv1, PESOS_DV2);

        return (c.charAt(12) - '0') == dv1 && (c.charAt(13) - '0') == dv2;
    }

    public static boolean validarEmail(String email) {
        return email != null && !email.isBlank() && email.contains("@");
    }

    public static boolean validarTelefone(String telefone) {
        String tel = somenteDigitos(telefone);
        return tel.length() == 10 || tel.length() == 11;
    }

    public static String removerMascara(String valor) {
        if (valor == null) {
            return "";
        }
        return valor.toUpperCase().replaceAll("[./\\-\\s]", "");
    }

    private static String somenteDigitos(String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replaceAll("\\D", "");
    }

    private static int calcularDigito(String base, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            int valor = base.charAt(i) - 48;
            soma += valor * pesos[i];
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}