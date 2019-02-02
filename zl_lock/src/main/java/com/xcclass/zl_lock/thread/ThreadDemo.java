package com.xcclass.zl_lock.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        User user=new User();
        Consumer consumer = new Consumer(user);
        consumer.start();
        Producer producer =new Producer(user);
        producer.start();
    }

}
class Consumer extends Thread{
    private User user;
    public Consumer(User user){
        this.user=user;
    }
    @Override
    public void run() {
        while(true){
            synchronized (user){
                if(user.isFlag()){
                    //消费者读取消息
                    read();
                    //等待生产者生产
                    waitProducer();
                }
            }
        }
    }

    private  void read(){
        System.out.println("姓名："+user.getName()+"|"+"性别："+user.getSex());
    }
    private  void waitProducer() {
        user.setFlag(false);
        try {
            user.wait();
        } catch (InterruptedException e) {
        }
    }
}
class Producer extends Thread{
    private User user;
    int count=0;
    public Producer(User user){
        this.user=user;
    }
    @Override
    public void run() {
        while(true){
            synchronized (user){
                if(!user.isFlag()){
                    write();
                    notifyConsumer();
                }
            }
        }
    }
    private void notifyConsumer(){
        user.notify();
        user.setFlag(true);
    }
    private void write(){
        if(count==0){
            user.setName("陈德炎");
            user.setSex("男");
        }else{
            user.setName("小红");
            user.setSex("女");
        }
        count=(count+1)%2;
    }
}