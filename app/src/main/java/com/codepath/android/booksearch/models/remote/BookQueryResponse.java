package com.codepath.android.booksearch.models.remote;

import java.util.List;

public class BookQueryResponse {

    private int start;
    private int num_found;
    private int numFound;
    private List<DocsBean> docs;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNum_found() {
        return num_found;
    }

    public void setNum_found(int num_found) {
        this.num_found = num_found;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public List<DocsBean> getDocs() {
        return docs;
    }

    public void setDocs(List<DocsBean> docs) {
        this.docs = docs;
    }

    public static class DocsBean {

        private String title_suggest;
        private int cover_i;
        private boolean has_fulltext;
        private String title;
        private String lending_identifier_s;
        private String ia_collection_s;
        private int first_publish_year;
        private String type;
        private int ebook_count_i;
        private int edition_count;
        private String key;
        private boolean public_scan_b;
        private int last_modified_i;
        private String lending_edition_s;
        private String cover_edition_key;
        private String printdisabled_s;
        private List<String> edition_key;
        private List<String> isbn;
        private List<String> text;
        private List<String> author_name;
        private List<String> contributor;
        private List<String> ia_loaded_id;
        private List<String> seed;
        private List<String> oclc;
        private List<String> ia;
        private List<String> author_key;
        private List<String> subject;
        private List<String> publish_place;
        private List<String> ia_box_id;
        private List<String> id_goodreads;
        private List<String> author_alternative_name;
        private List<String> id_overdrive;
        private List<String> publisher;
        private List<String> language;
        private List<String> lccn;
        private List<String> id_librarything;
        private List<String> person;
        private List<Integer> publish_year;
        private List<String> place;
        private List<String> time;
        private List<String> publish_date;

        public String getTitle_suggest() {
            return title_suggest;
        }

        public void setTitle_suggest(String title_suggest) {
            this.title_suggest = title_suggest;
        }

        public int getCover_i() {
            return cover_i;
        }

        public void setCover_i(int cover_i) {
            this.cover_i = cover_i;
        }

        public boolean isHas_fulltext() {
            return has_fulltext;
        }

        public void setHas_fulltext(boolean has_fulltext) {
            this.has_fulltext = has_fulltext;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLending_identifier_s() {
            return lending_identifier_s;
        }

        public void setLending_identifier_s(String lending_identifier_s) {
            this.lending_identifier_s = lending_identifier_s;
        }

        public String getIa_collection_s() {
            return ia_collection_s;
        }

        public void setIa_collection_s(String ia_collection_s) {
            this.ia_collection_s = ia_collection_s;
        }

        public int getFirst_publish_year() {
            return first_publish_year;
        }

        public void setFirst_publish_year(int first_publish_year) {
            this.first_publish_year = first_publish_year;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getEbook_count_i() {
            return ebook_count_i;
        }

        public void setEbook_count_i(int ebook_count_i) {
            this.ebook_count_i = ebook_count_i;
        }

        public int getEdition_count() {
            return edition_count;
        }

        public void setEdition_count(int edition_count) {
            this.edition_count = edition_count;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public boolean isPublic_scan_b() {
            return public_scan_b;
        }

        public void setPublic_scan_b(boolean public_scan_b) {
            this.public_scan_b = public_scan_b;
        }

        public int getLast_modified_i() {
            return last_modified_i;
        }

        public void setLast_modified_i(int last_modified_i) {
            this.last_modified_i = last_modified_i;
        }

        public String getLending_edition_s() {
            return lending_edition_s;
        }

        public void setLending_edition_s(String lending_edition_s) {
            this.lending_edition_s = lending_edition_s;
        }

        public String getCover_edition_key() {
            return cover_edition_key;
        }

        public void setCover_edition_key(String cover_edition_key) {
            this.cover_edition_key = cover_edition_key;
        }

        public String getPrintdisabled_s() {
            return printdisabled_s;
        }

        public void setPrintdisabled_s(String printdisabled_s) {
            this.printdisabled_s = printdisabled_s;
        }

        public List<String> getEdition_key() {
            return edition_key;
        }

        public void setEdition_key(List<String> edition_key) {
            this.edition_key = edition_key;
        }

        public List<String> getIsbn() {
            return isbn;
        }

        public void setIsbn(List<String> isbn) {
            this.isbn = isbn;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }

        public List<String> getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(List<String> author_name) {
            this.author_name = author_name;
        }

        public List<String> getContributor() {
            return contributor;
        }

        public void setContributor(List<String> contributor) {
            this.contributor = contributor;
        }

        public List<String> getIa_loaded_id() {
            return ia_loaded_id;
        }

        public void setIa_loaded_id(List<String> ia_loaded_id) {
            this.ia_loaded_id = ia_loaded_id;
        }

        public List<String> getSeed() {
            return seed;
        }

        public void setSeed(List<String> seed) {
            this.seed = seed;
        }

        public List<String> getOclc() {
            return oclc;
        }

        public void setOclc(List<String> oclc) {
            this.oclc = oclc;
        }

        public List<String> getIa() {
            return ia;
        }

        public void setIa(List<String> ia) {
            this.ia = ia;
        }

        public List<String> getAuthor_key() {
            return author_key;
        }

        public void setAuthor_key(List<String> author_key) {
            this.author_key = author_key;
        }

        public List<String> getSubject() {
            return subject;
        }

        public void setSubject(List<String> subject) {
            this.subject = subject;
        }

        public List<String> getPublish_place() {
            return publish_place;
        }

        public void setPublish_place(List<String> publish_place) {
            this.publish_place = publish_place;
        }

        public List<String> getIa_box_id() {
            return ia_box_id;
        }

        public void setIa_box_id(List<String> ia_box_id) {
            this.ia_box_id = ia_box_id;
        }

        public List<String> getId_goodreads() {
            return id_goodreads;
        }

        public void setId_goodreads(List<String> id_goodreads) {
            this.id_goodreads = id_goodreads;
        }

        public List<String> getAuthor_alternative_name() {
            return author_alternative_name;
        }

        public void setAuthor_alternative_name(List<String> author_alternative_name) {
            this.author_alternative_name = author_alternative_name;
        }

        public List<String> getId_overdrive() {
            return id_overdrive;
        }

        public void setId_overdrive(List<String> id_overdrive) {
            this.id_overdrive = id_overdrive;
        }

        public List<String> getPublisher() {
            return publisher;
        }

        public void setPublisher(List<String> publisher) {
            this.publisher = publisher;
        }

        public List<String> getLanguage() {
            return language;
        }

        public void setLanguage(List<String> language) {
            this.language = language;
        }

        public List<String> getLccn() {
            return lccn;
        }

        public void setLccn(List<String> lccn) {
            this.lccn = lccn;
        }

        public List<String> getId_librarything() {
            return id_librarything;
        }

        public void setId_librarything(List<String> id_librarything) {
            this.id_librarything = id_librarything;
        }

        public List<String> getPerson() {
            return person;
        }

        public void setPerson(List<String> person) {
            this.person = person;
        }

        public List<Integer> getPublish_year() {
            return publish_year;
        }

        public void setPublish_year(List<Integer> publish_year) {
            this.publish_year = publish_year;
        }

        public List<String> getPlace() {
            return place;
        }

        public void setPlace(List<String> place) {
            this.place = place;
        }

        public List<String> getTime() {
            return time;
        }

        public void setTime(List<String> time) {
            this.time = time;
        }

        public List<String> getPublish_date() {
            return publish_date;
        }

        public void setPublish_date(List<String> publish_date) {
            this.publish_date = publish_date;
        }
    }
}
