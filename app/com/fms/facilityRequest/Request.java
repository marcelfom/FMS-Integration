package com.fms.facilityRequest;

public class Request implements IRequest {

	private int requestId;
	private String problemDescription;
    private RequestType requestType;
	private String requestDate;
    private String requestedBy;


    @Override
    public int getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

	@Override
	public String getProblemDescription() {
		return problemDescription;
	}

	@Override
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	@Override
	public String getRequestDate() {
		return requestDate;
	}

	@Override
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

    @Override
    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public void setRequestType(RequestType type) {
        this.requestType = type;
    }

    @Override
    public String getRequestedBy() {
        return requestedBy;
    }

    @Override
    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

}

