package info.batey.examples.network;

public class ApplicationResponse {

    private final int status;
    private final String body;
    private final long requestDuration;

    public ApplicationResponse(int status, String body, long requestDuration) {
        this.status = status;
        this.body = body;
        this.requestDuration = requestDuration;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }

    public long getRequestDuration() {
        return requestDuration;
    }
}
