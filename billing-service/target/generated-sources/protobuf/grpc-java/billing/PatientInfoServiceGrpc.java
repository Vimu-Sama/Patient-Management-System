package billing;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.0)",
    comments = "Source: patient_info_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PatientInfoServiceGrpc {

  private PatientInfoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "PatientInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<billing.PatientInfoRequest,
      billing.PatientInfoResponse> getGetPatientInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatientInformation",
      requestType = billing.PatientInfoRequest.class,
      responseType = billing.PatientInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<billing.PatientInfoRequest,
      billing.PatientInfoResponse> getGetPatientInformationMethod() {
    io.grpc.MethodDescriptor<billing.PatientInfoRequest, billing.PatientInfoResponse> getGetPatientInformationMethod;
    if ((getGetPatientInformationMethod = PatientInfoServiceGrpc.getGetPatientInformationMethod) == null) {
      synchronized (PatientInfoServiceGrpc.class) {
        if ((getGetPatientInformationMethod = PatientInfoServiceGrpc.getGetPatientInformationMethod) == null) {
          PatientInfoServiceGrpc.getGetPatientInformationMethod = getGetPatientInformationMethod =
              io.grpc.MethodDescriptor.<billing.PatientInfoRequest, billing.PatientInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPatientInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  billing.PatientInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  billing.PatientInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PatientInfoServiceMethodDescriptorSupplier("GetPatientInformation"))
              .build();
        }
      }
    }
    return getGetPatientInformationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientInfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PatientInfoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PatientInfoServiceStub>() {
        @java.lang.Override
        public PatientInfoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PatientInfoServiceStub(channel, callOptions);
        }
      };
    return PatientInfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientInfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PatientInfoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PatientInfoServiceBlockingStub>() {
        @java.lang.Override
        public PatientInfoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PatientInfoServiceBlockingStub(channel, callOptions);
        }
      };
    return PatientInfoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientInfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PatientInfoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PatientInfoServiceFutureStub>() {
        @java.lang.Override
        public PatientInfoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PatientInfoServiceFutureStub(channel, callOptions);
        }
      };
    return PatientInfoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getPatientInformation(billing.PatientInfoRequest request,
        io.grpc.stub.StreamObserver<billing.PatientInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPatientInformationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PatientInfoService.
   */
  public static abstract class PatientInfoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PatientInfoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PatientInfoService.
   */
  public static final class PatientInfoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PatientInfoServiceStub> {
    private PatientInfoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientInfoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PatientInfoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPatientInformation(billing.PatientInfoRequest request,
        io.grpc.stub.StreamObserver<billing.PatientInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPatientInformationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PatientInfoService.
   */
  public static final class PatientInfoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PatientInfoServiceBlockingStub> {
    private PatientInfoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientInfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PatientInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public billing.PatientInfoResponse getPatientInformation(billing.PatientInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPatientInformationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PatientInfoService.
   */
  public static final class PatientInfoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PatientInfoServiceFutureStub> {
    private PatientInfoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientInfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PatientInfoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<billing.PatientInfoResponse> getPatientInformation(
        billing.PatientInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPatientInformationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PATIENT_INFORMATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PATIENT_INFORMATION:
          serviceImpl.getPatientInformation((billing.PatientInfoRequest) request,
              (io.grpc.stub.StreamObserver<billing.PatientInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetPatientInformationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              billing.PatientInfoRequest,
              billing.PatientInfoResponse>(
                service, METHODID_GET_PATIENT_INFORMATION)))
        .build();
  }

  private static abstract class PatientInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return billing.PatientInfoServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientInfoService");
    }
  }

  private static final class PatientInfoServiceFileDescriptorSupplier
      extends PatientInfoServiceBaseDescriptorSupplier {
    PatientInfoServiceFileDescriptorSupplier() {}
  }

  private static final class PatientInfoServiceMethodDescriptorSupplier
      extends PatientInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PatientInfoServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PatientInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientInfoServiceFileDescriptorSupplier())
              .addMethod(getGetPatientInformationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
