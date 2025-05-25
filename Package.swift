// swift-tools-version:5.3

import PackageDescription

let package = Package(
    name: "Shared",
    platforms: [
        .iOS(.v14),
    ],
    products: [
        .library(name: "Shared", targets: ["Shared"])
    ],
    targets: [
        .binaryTarget(
            name: "Shared",
            url: "https://github.com/shalva97/overwatch-player-search-api/releases/download/1.9/OverwatchPlayerSearchApi.xcframework.zip",
            checksum: "57a9556f96aaba1590897fdc28e2e1e41181a972e29dbb06804e023f26ccd65e")
    ]
)