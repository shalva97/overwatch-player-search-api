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
            url: "https://github.com/shalva97/overwatch-player-search-api/releases/download/1.9/Shared.xcframework.zip",
            checksum: "a8468cbdddc7bd5b1ce74f5742fd56a2063a8fed7c508fbfd2be528961bffaf9")
    ]
)