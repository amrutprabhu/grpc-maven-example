package com.amrut.prabhu.grpc;

import com.amrut.prabhu.grpc.server.impl.ServerImpl;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        io.grpc.Server server = ServerBuilder.forPort(55005)
                .addService(new ServerImpl())
                .build();
        server.start();
        System.out.println("Server has started ......");
        AddShutDownHook(server);
        server.awaitTermination();
    }

    private static void AddShutDownHook(io.grpc.Server server) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdown();
            System.out.println("Server is shutting Down ......");
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

}
