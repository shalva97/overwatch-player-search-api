// swift-tools-version:5.3

import PackageDescription

let package = Package(
    name: "OverwatchPlayerSearchApi",
    platforms: [
        .iOS(.v14),
        .macOS(.v11),
    ],
    products: [
        .library(name: "OverwatchPlayerSearchApi", targets: ["OverwatchPlayerSearchApi"])
    ],
    targets: [
        .binaryTarget(
            name: "OverwatchPlayerSearchApi",
            url: "https://github.com/shalva97/overwatch-player-search-api/releases/download/1.9/OverwatchPlayerSearchApi.xcframework.zip",
            checksum: "7edf7ff03e0ed0e0b70d1dbf0aa7ded07d861ddea649d802c261e1f828dc9ef4")
    ]
)
