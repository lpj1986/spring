package win.elegentjs.aop.advice.introduction;

public class TesterImpl implements Tester {

    private boolean isBusy;

    @Override
    public boolean isBusyAsTester() {
        return isBusy;
    }

    @Override
    public void test() {
        System.out.println("I will ensure the quality.");
    }


    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
