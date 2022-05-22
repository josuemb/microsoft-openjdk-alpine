FROM docker.io/library/alpine:latest
ARG JDK_LTS_VERSION="17"
ARG JDK_FILE="microsoft-jdk-${JDK_LTS_VERSION}-alpine-x64.tar.gz"
ARG JDK_URL="https://aka.ms/download-jdk/${JDK_FILE}"
ARG JDK_PATH="/microsoft-jdk-${JDK_LTS_VERSION}"
RUN wget -q ${JDK_URL}
RUN tar -xzf ${JDK_FILE}
RUN mv jdk* ${JDK_PATH}
RUN rm -f ${JDK_FILE}
ENV JAVA_HOME=${JDK_PATH}
ENV PATH="$PATH:${JAVA_HOME}/bin"