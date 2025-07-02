package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("CourseRetrieve started!");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as first argument!");
            return;
        }
        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            LOG.error("Unexpected Error");
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieved courses for author: '{}'", authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();

        String coursesToStore = courseRetrievalService.getCourseFor(authorId);
        LOG.info("Retrieved the following courses{}", coursesToStore);
    }
}
