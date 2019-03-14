package com.xcclass.zl_lock.design.singleton;

enum UserEnum {
        HTTP_200(200,"请求成功") ,HTTP_500(500,"请求失败");
        private Integer code;
        private String message;
        UserEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
        public Integer getCode() {
            return code;
        }
        public void setCode(Integer code) {
            this.code = code;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }

    public static void main(String[] args) {
        System.out.println(UserEnum.HTTP_200.code);
        System.out.println(UserEnum.HTTP_500.code);
    }
}
