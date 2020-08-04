package com.amrut.prabhu.grpc.server.impl;

import com.amrut.prabhu.grpc.CommunicationServiceGrpc;
import com.amrut.prabhu.grpc.ServiceDefinition;
import io.grpc.stub.StreamObserver;

public class ServerImpl extends CommunicationServiceGrpc.CommunicationServiceImplBase {
        @Override
        public void sendRequest(ServiceDefinition.Request request, StreamObserver<ServiceDefinition.Response> responseObserver) {
            ServiceDefinition.Response response = ServiceDefinition.Response.newBuilder()
                    .setName(" Response from Server for request name: " + request.getName())
                    .setValue(2222)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }