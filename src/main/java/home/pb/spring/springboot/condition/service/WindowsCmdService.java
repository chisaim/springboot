package home.pb.spring.springboot.condition.service;

public class WindowsCmdService implements CmdService {
    @Override
    public void print() {
        System.out.println("This is WindowsCmdService print");
    }
}
