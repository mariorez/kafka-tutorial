package dev.mario.kafkatutorial.model;

public class TutorialModel {

    String id;
    String topicName;
    String publisher;
    String location;
    String type;
    String topicId;

    public String getId() {
        return id;
    }

    public TutorialModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getTopicName() {
        return topicName;
    }

    public TutorialModel setTopicName(String topicName) {
        this.topicName = topicName;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public TutorialModel setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public TutorialModel setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getType() {
        return type;
    }

    public TutorialModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getTopicId() {
        return topicId;
    }

    public TutorialModel setTopicId(String topicId) {
        this.topicId = topicId;
        return this;
    }

    @Override
    public String toString() {
        return "TutorialModel{" +
                "id='" + id + '\'' +
                ", topicName='" + topicName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", topicId='" + topicId + '\'' +
                '}';
    }
}
