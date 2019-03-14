package com.xcclass.zl_lock.demo;

public class demo {
    public static void main(String[] args) {
        byte[] bytes = hexStringToByte("90");
        for (int i = 0; i <bytes.length ; i++) {
            System.out.println(bytes[i]);
        }
        String s2 = toHexString(bytes);

        System.out.println(s2);

    }
    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }

        public static byte[] hexStringToByte(String hex) {
            int len = (hex.length() / 2);
            byte[] result = new byte[len];
            char[] achar = hex.toCharArray();
            for (int i = 0; i < len; i++) {
                int pos = i * 2;
                result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
            }
            return result;
        }
        private static byte toByte(char c) {
            byte b = (byte) "0123456789ABCDEF".indexOf(c);
            return b;
        }

}
