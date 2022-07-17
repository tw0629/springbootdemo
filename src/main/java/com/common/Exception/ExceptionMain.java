package com.common.Exception;

/**
 * @author David Tian
 * @desc
 * @since 2022/4/18 23:53
 */
public class ExceptionMain {

    public static void main(String[] args) {
        try{
            process();
        }catch (AException e){
            System.out.println("AException: "+e.getMessage());
        }catch (BException e) {
            System.out.println("BException: "+e.getMessage());

        }catch (ServiceException e){
            System.out.println("ServiceException: "+e.getMessage());

        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());

        }
    }

    public static void process() throws Exception {

        //a();
        b();
        //service();
        e();
    }


    public static void a(){
        throw new AException("a error");
    }

    public static void b(){
        throw new BException("b error");
    }

    public static void service(){
        throw new ServiceException("service error");
    }

    public static void e() throws Exception {
        throw new Exception("e error");
    }

}
