package sandbox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(length = 1000)
    private String text;

    public Post() {
    }

    public Post(final Member member, final String text) {
        this(null, member, text);
    }

    public Post(final Long id, final Member member, final String text) {
        this.id = id;
        this.member = member;
        this.text = text;
    }

    public void editText(final String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public String getText() {
        return text;
    }
}
