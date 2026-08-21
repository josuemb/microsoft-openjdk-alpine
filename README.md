# microsoft-openjdk-alpine
Dockerfiles to create Microsoft OpenJDK images with Alpine Linux.

## Available Versions

| Version | Directory | Status |
|---------|-----------|--------|
| 17 (LTS) | `17/` | Current LTS |
| 21 (LTS) | `21/` | Current LTS |

## Changes

- **Removed**: Java 11 (End of Life as of September 2023)
- **Added**: Java 21 (current LTS, released September 2023)
- **Improved**: Pinned Alpine to 3.20, multi-stage builds to reduce image size

## References

Only versions marked as LTS are considered: https://learn.microsoft.com/en-us/java/openjdk/download
