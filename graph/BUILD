#
# Copyright (C) 2022 Vaticle
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

load("@vaticle_dependencies//tool/checkstyle:rules.bzl", "checkstyle_test")
load("@vaticle_dependencies//builder/java:rules.bzl", "native_java_libraries")
package(
    default_visibility = [
        "//concept:__pkg__",
        "//database:__pkg__",
        "//traversal:__pkg__",
        "//reasoner:__pkg__"
    ]
)

native_java_libraries(
    name = "graph",
    srcs = glob(["*.java", "*/*.java", "*/*/*.java"]),
    deps = [
        # External dependencies from Vaticle
        "@vaticle_typedb_common//:common",

        # External dependencies from Vaticle
        "@vaticle_typeql//java:typeql-lang",
        "@vaticle_typeql//java/common:common",
        "@vaticle_typeql//java/pattern:pattern",

        # External Maven Dependencies
        "@maven//:com_google_code_findbugs_jsr305",
    ],
    native_libraries_deps = [
        # Internal dependencies
        "//common:common",
        "//encoding:encoding",
    ],
    tags = ["maven_coordinates=com.vaticle.typedb:typedb-core-graph:{pom_version}"],
    visibility = ["//visibility:public"],
)

checkstyle_test(
    name = "checkstyle",
    include = glob(["*", "*/*", "*/*/*"]),
    license_type = "agpl-header",
)
