package com.amrut.prabhu.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 55005)
                .usePlaintext() // To disable ssl since we are not providing certificates.
                .build();
        CommunicationServiceGrpc.CommunicationServiceBlockingStub communicationServiceBlockingStub = CommunicationServiceGrpc.newBlockingStub(managedChannel);
        System.out.println("Client Sending request ...");
        ServiceDefinition.Response response = communicationServiceBlockingStub.sendRequest(ServiceDefinition.Request.newBuilder()
                .setName("Amrut")
                .setValue(10000)
                .build());

        System.out.println("Response: " + response.getName() + " " + response.getValue());
    }
}
