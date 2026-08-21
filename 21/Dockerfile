FROM docker.io/library/alpine:3.20 AS builder
ARG JDK_LTS_VERSION="21"
ARG JDK_FILE="microsoft-jdk-${JDK_LTS_VERSION}-alpine-x64.tar.gz"
ARG JDK_URL="https://aka.ms/download-jdk/${JDK_FILE}"
RUN wget -q ${JDK_URL} && \
    tar -xzf ${JDK_FILE} && \
    rm -f ${JDK_FILE}

FROM docker.io/library/alpine:3.20
ARG JDK_LTS_VERSION="21"
ARG JDK_PATH="/opt/microsoft-jdk-${JDK_LTS_VERSION}"
COPY --from=builder /jdk-${JDK_LTS_VERSION}* ${JDK_PATH}
ENV JAVA_HOME=${JDK_PATH}
ENV PATH="$PATH:${JAVA_HOME}/bin"
